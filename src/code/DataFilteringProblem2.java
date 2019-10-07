package code;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.javatuples.Pair;
import org.javatuples.Triplet;

public class DataFilteringProblem2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<VisitedUser> vus = readFile("./src/data/Q3.csv");
		
		System.out.println(getSitesWithMostUsersForCountry(vus, "BDV"));
		System.out.println(findUsersWithinTimestampRangeWithCutoffNumVisit(
				vus, "2019-02-03 00:00:00", "2019-02-04 23:59:59", 10));
		System.out.println(findTopThreeSitesWithHighestLatestUsersCount(vus));
		System.out.println(getNumUsersWithSameFirstAndLastSites(vus));
	}

	public static int getNumUsersWithSameFirstAndLastSites(List<VisitedUser> vus) {
		
		Map<String, VisitedUser[]> userToFirstAndLast = new HashMap<>();
		for (VisitedUser vu : vus) {
			String uid = vu.getUser_id();
			String ts = vu.getTs();
			if (userToFirstAndLast.containsKey(uid)) {
				VisitedUser[] firstAndLast = userToFirstAndLast.get(uid);
				VisitedUser currFirst = firstAndLast[0];
				VisitedUser currLast = firstAndLast[1];
				
				if (ts.compareTo(currFirst.getTs()) < 0) {
					firstAndLast[0] = vu;
					
				} else if (ts.compareTo(currLast.getTs()) > 0) {
					firstAndLast[1] = vu;
				}
				
			} else {
				VisitedUser[] temp = {vu, vu};
				userToFirstAndLast.put(uid, temp);
			}
		}
		
		int ans = 0;
		for (VisitedUser[] vals  : userToFirstAndLast.values()) {
			VisitedUser f = vals[0];
			VisitedUser l = vals[1];

			// To be more clear, I provide two answers:
			// 1. Includes case where first/last visits have the same timestamp.
//			if (vals[0].getSite_id().equals(vals[1].getSite_id()) && vals[0].getTs() != vals[1].getTs()) {
//				System.out.println("f: " + f + ", l: " + l);
//				ans++;
//			}
			
			// 2. Only includes cases where first/last timestamps are different.
			if (vals[0].getSite_id().equals(vals[1].getSite_id())) {
				ans++;
			}
		}
		
		return ans;
	}
	
	public static List<Pair<String, Integer>> findTopThreeSitesWithHighestLatestUsersCount(List<VisitedUser> vus) {
		Map<String, VisitedUser> userTolatestTsMap = new HashMap<>();
		for (VisitedUser vu : vus) {
			String uid = vu.getUser_id();
			String ts = vu.getTs();
			if (userTolatestTsMap.containsKey(uid)) {
				String currLatestTs = userTolatestTsMap.get(uid).getTs();
				if (ts.compareTo(currLatestTs) > 0) {
					userTolatestTsMap.replace(uid, vu);
				}
			} else {
				userTolatestTsMap.put(uid, vu);
			}
		}
		
		Map<String, Integer> siteToLatestUserCount = new HashMap<>();
		for (Map.Entry<String, VisitedUser> e : userTolatestTsMap.entrySet()) {
			VisitedUser user = e.getValue();
			String site = user.getSite_id();
			if (siteToLatestUserCount.containsKey(site)) {
				siteToLatestUserCount.put(site, siteToLatestUserCount.get(site) + 1);
			} else {
				siteToLatestUserCount.put(site, 1);
			}
		}
		
		// Better solution: 
		// https://stackoverflow.com/questions/18971849/best-way-to-get-top-n-keyssorted-by-values-in-a-hashmap
		List<Pair<String, Integer>> topThreeSites = new ArrayList<>();
		siteToLatestUserCount.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return -o1.getValue().compareTo(o2.getValue());
			}
		}).forEach(e -> {if (topThreeSites.size() < 3) {
			topThreeSites.add(new Pair<String, Integer>(e.getKey(), e.getValue()));
		}});
		
		return topThreeSites;
	}
	
	public static List<Triplet<String, String, Integer>> findUsersWithinTimestampRangeWithCutoffNumVisit(
			List<VisitedUser> vus, String s, String e, int cutoffNumVisit) {
		List<VisitedUser> filtered = vus.stream()
				.filter(vu -> vu.getTs().compareTo(s) >= 0 && vu.getTs().compareTo(e) <= 0)
				.collect(Collectors.toList());
		
		Map<String, Map<String, Integer>> userToSiteVisitCount = new HashMap<>();
		for (VisitedUser vu : filtered) {
			String user = vu.getUser_id();
			String site = vu.getSite_id();
			if (userToSiteVisitCount.containsKey(user)) {
				Map<String, Integer> siteVisitCounts = userToSiteVisitCount.get(user);
				if (siteVisitCounts.containsKey(site)) {
					siteVisitCounts.replace(site, siteVisitCounts.get(site) + 1);
				} else {
					siteVisitCounts.put(site, 1);
				}
				
			} else {
				Map<String, Integer> siteVisitCounts = new HashMap<>();
				siteVisitCounts.put(site, 1);
				userToSiteVisitCount.put(user, siteVisitCounts);
			}
		}
		
		List<Triplet<String, String, Integer>> ans = new ArrayList<>();
		for (Map.Entry<String, Map<String, Integer>> e1 : userToSiteVisitCount.entrySet()) {
			String uid = e1.getKey();
			for (Map.Entry<String, Integer> e2 : e1.getValue().entrySet()) {
				String sid = e2.getKey();
				int vc = e2.getValue();
				if (vc > 10) {
					ans.add(new Triplet<>(uid, sid, vc));
				}
			}
		}
		
		return ans;
	}
	
	public static Map<String, Integer> getSitesWithMostUsersForCountry(List<VisitedUser> vus, String country) {
		
		List<VisitedUser> filtered = vus.stream()
				.filter(vu -> vu.getCountry_id().equals(country))
				.collect(Collectors.toList());
		
		Map<String, Set<String>> siteToUsers = new HashMap<>();
		int maxUsersCount = 0;
		
		for (VisitedUser vu : filtered) {
			String site = vu.getSite_id();
			String user = vu.getUser_id();
			if (siteToUsers.containsKey(site)) {
				siteToUsers.get(site).add(user);
				
			} else {
				Set<String> users = new HashSet<>();
				users.add(user);
				siteToUsers.put(site, users);
			}
			
			int currCount = siteToUsers.get(site).size();
			maxUsersCount = Math.max(maxUsersCount, currCount);
		}
		
		int max = maxUsersCount;
		Map<String, Integer> ans = siteToUsers.entrySet().stream()
				.filter(entry -> entry.getValue().size() == max)
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue().size()));
		
		return ans;
	}
	
	public static List<VisitedUser> readFile(String filename) throws IOException {
		
		List<VisitedUser> vus = null;
		Pattern pattern = Pattern.compile(",");

		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			vus = reader.lines().skip(1).map(line -> {
				String[] x = pattern.split(line); 
			    return new VisitedUser(x[0], x[1], x[2], x[3]);
			    }).collect(Collectors.toList());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file name " + filename + " not found.");
			e.printStackTrace();
		}
		
		return vus;
	}
	
	public static class VisitedUser {

		private String ts;
		private String user_id;
		private String country_id;
		private String site_id;
		
		public VisitedUser(String ts, String user_id, String country_id, String site_id) {
			this.ts = ts;
			this.user_id = user_id;
			this.country_id = country_id;
			this.site_id = site_id;
		}
			
		public String getTs() {
			return ts;
		}

		public void setTs(String ts) {
			this.ts = ts;
		}

		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

		public String getCountry_id() {
			return country_id;
		}

		public void setCountry_id(String country_id) {
			this.country_id = country_id;
		}

		public String getSite_id() {
			return site_id;
		}

		public void setSite_id(String site_id) {
			this.site_id = site_id;
		}
		
		@Override
		public String toString() {
			return "ts: " + ts + ", user_id: " + user_id + ", country_id: " + country_id + ", site_id: " + site_id;
		}
	}
}
