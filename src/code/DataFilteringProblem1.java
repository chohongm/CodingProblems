package code;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.google.gson.Gson;

public class DataFilteringProblem1 {

	public static void main(String[] args) throws IOException {
		//System.out.println(new File(".").getAbsoluteFile());
		List<Product> ps = readFile("./src/data/Q2.txt");
		System.out.println("Most popular product(s) based on the number of purchasers: " + 
		productWithMostUsers(ps));
		System.out.println("Most popular product(s) based on the quantity of goods sold: " + 
		productWithMostQuantity(ps));
	}

	public static List<String> productWithMostUsers(List<Product> ps) {
		
		Map<String, Set<String>> map = new HashMap<>();
		int maxCount = 0;
		List<String> ans = new ArrayList<>();
		
		for (Product p : ps) {
			String pid = p.getProductId();
			String uid = p.getUserId();
			map.putIfAbsent(pid, new HashSet<>());
			Set<String> users = map.get(pid);
			users.add(uid);
			int numUsers = users.size();
			if (numUsers > maxCount) {
				ans = new ArrayList<>();
				ans.add(pid);
				maxCount = numUsers;
			} else if (numUsers == maxCount) {
				ans.add(pid);
			}
		}
		return ans;
	}
	
	public static List<String> productWithMostQuantity(List<Product> ps) {
		
		Map<String, Integer> map = new HashMap<>();
		int maxQuantity = 0;
		List<String> ans = new ArrayList<>();
		
		for (Product p : ps) {
			String pid = p.getProductId();
			int quantity = p.getQuantity();
			
			if (map.containsKey(pid)) {
				map.replace(pid, map.get(pid) + quantity);
				
			} else {
				map.put(pid, quantity);
			}
			
			int currQuantity = map.get(pid);
			if (currQuantity > maxQuantity) {
				ans = new ArrayList<>();
				ans.add(pid);
				maxQuantity = currQuantity;
			} else if (currQuantity == maxQuantity) {
				ans.add(pid);
			}
		}
		return ans;
	}
	
	public static List<Product> readFile(String filename) throws IOException {
		
		List<Product> ps = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			Gson g = new Gson();
			String row;
			while ((row = reader.readLine()) != null) {
				Product p = g.fromJson(row, Product.class);
				//System.out.println(p);
				ps.add(p);
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file name " + filename + " not found.");
			e.printStackTrace();
		}
		
		return ps;
	}
	
	public static class Product {
		
		private String user_id;
		private String product_id;
		private int quantity;
		
		public Product(String user_id, String product_id, int quantity) {
			this.user_id = user_id;
			this.product_id = product_id;
			this.quantity = quantity;
		}
		
		public void setUserId(String userId) {
			this.user_id = userId;
		}
		
		public String getUserId() {
			return user_id;
		}
		
		public void setProductId(String productId) {
			this.product_id = productId;
		}
		
		public String getProductId() {
			return product_id;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		public int getQuantity() {
			return quantity;
		}
		
		@Override
		public String toString() {
			return "pid: " + product_id + ", uid: " + user_id + ", quantity: " + quantity;
		}
	}
}
