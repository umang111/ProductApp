package com.product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductAppApplication {


	static List<Products> products=new ArrayList<>();
	static {
		
		products.add(
			new Products("Biskit", 20, "Eatable")
		);
		products.add(
			new Products("Popcorn", 30, "Eatable")
		);
		products.add(
			new Products("Chocolate", 15, "Eatable")
		);
		products.add(
			new Products("Samosa", 10, "Eatable")
		);
		products.add(
			new Products("BananaShake", 20, "Drinkable")
		);
		products.add(
			new Products("ChocolateShake", 25, "Drinkable")
		);
		products.add(
			new Products("Juice", 15, "Drinkable")
		);
	}
	public static void main(String[] args) {

		//List of All Products
		products.stream().forEach(product->System.out.println(product));

		// sorted products in Aphabetic order .
		List<Products> allSortedProducts=
						products.stream().sorted(((o1, o2) ->o1.getName().compareToIgnoreCase(o2.getName()) ))
						.collect(Collectors.toList());

	    System.out.println();
		System.out.println("List of all sorted products");
		System.out.println(allSortedProducts);

		//sorted products by price in ascending order
		List<Products> sortedByPriceInascendingOrder= (List<Products>) products.stream().sorted(new Comparator<Products>() {

			@Override
			public int compare(Products o1, Products o2) {
				return (int) (o1.getPrice()-o2.getPrice()) ;
			}
			
		}).collect(Collectors.toList());
		System.out.println();
		System.out.println("Product list sorted by price in ascending order");
		System.out.println(sortedByPriceInascendingOrder);

		//sorted product by price in descending order
		List<Products> sortedByPricedescendingOrder= (List<Products>) products.stream().sorted(new Comparator<Products>() {

			@Override
			public int compare(Products o1, Products o2) {
				return (int) (o2.getPrice()-o1.getPrice()) ;
			}
			
		}).collect(Collectors.toList());
		System.out.println();
		System.out.println("Product list sorted by price in Descending order");
		System.out.println(sortedByPricedescendingOrder);

		// maximum price product
		Optional<Products> maximumPriceProduct = products.stream().max(Comparator.comparing(Products::getPrice));
		System.out.println("maximum price product ");
		System.out.println(maximumPriceProduct);

		//minimum price product
		Optional<Products> minimumPriceProduct = products.stream().min(Comparator.comparing(Products::getPrice));
		System.out.println("minimum price product ");
		System.out.println(minimumPriceProduct);





		//List of products after GST
		List<Products> applyGst= products.stream().map(product-> new Products(
							product.getName(),
							product.getPrice()*1.8,
							product.getType())).collect(Collectors.toList());
		System.out.println();
		System.out.println("Products price after GST");
		System.out.println(applyGst);

		// List of only drinkable products
		List<Products> drinkableProducts=
		products.stream().filter(product-> product.getType()=="Drinkable")
		.map(product-> new Products(product.getName(),
									product.getPrice(),
									product.getType())).collect(Collectors.toList());
		
		System.out.println();
		System.out.println("List of Drinkable Products");
		System.out.println(drinkableProducts);

		// sorted list of only drinkable products
		List<Products> drinkableProductsSorted=
		products.stream().filter(product-> product.getType()=="Drinkable")
		.sorted(((o1, o2) ->o1.getName().compareToIgnoreCase(o2.getName()) ))
		.map(product-> new Products(product.getName(),
									product.getPrice(),
									product.getType())).collect(Collectors.toList());
		
		System.out.println();
		System.out.println("Sorted List of Drinkable Products **");
		System.out.println(drinkableProductsSorted);

		// Sorted by price in ascending order of drinkable

		List<Products> sortedByPriceInascendingOrderofDrinkable=
							 (List<Products>) products.stream().filter(product-> product.getType()=="Drinkable")
		                 		.sorted(new Comparator<Products>() {

			@Override
			public int compare(Products o1, Products o2) {
				return (int) (o1.getPrice()-o2.getPrice()) ;
			}
			
		}).collect(Collectors.toList());
		System.out.println();
		System.out.println("Product list of drinkable sorted by price in ascending order");
		System.out.println(sortedByPriceInascendingOrderofDrinkable);

		// Sorted by price in descending order of drinkable

		List<Products> sortedByPriceIndescendingOrderofDrinkable=
							 (List<Products>) products.stream().filter(product-> product.getType()=="Drinkable")
		                 		.sorted(new Comparator<Products>() {

			@Override
			public int compare(Products o1, Products o2) {
				return (int) (o2.getPrice()-o1.getPrice()) ;
			}
			
		}).collect(Collectors.toList());
		System.out.println();
		System.out.println("Product list of drinkable sorted by price in descending order");
		System.out.println(sortedByPriceIndescendingOrderofDrinkable);

		// maximum price drinkable product
		Optional<Products> maximumPriceOfDrinkable = products.stream().filter(product-> product.getType()=="Drinkable").max(Comparator.comparing(Products::getPrice));
		System.out.println();
		System.out.println("maximum price of drinkable products ");
		System.out.println(maximumPriceOfDrinkable);

		//minimum price drinkable product
		Optional<Products> minimumPriceOfDrinkable = products.stream().filter(product-> product.getType()=="Drinkable").min(Comparator.comparing(Products::getPrice));
		System.out.println();
		System.out.println("minimum price of drinkable products ");
		System.out.println(minimumPriceOfDrinkable);


		//List of Eatable Products
		List<Products> eatableProducts=
		products.stream().filter(product-> product.getType()=="Eatable")
		.map(product-> new Products(product.getName(),
									product.getPrice(),
									product.getType())).collect(Collectors.toList());
		
		System.out.println();
		System.out.println("List of Drinkable Products");
		System.out.println(eatableProducts);

		//sorted list of Eatable products
		List<Products> eatableProductsSorted=
		products.stream().filter(product-> product.getType()=="Eatable")
		.sorted(((o1, o2) ->o1.getName().compareToIgnoreCase(o2.getName()) ))
		.map(product-> new Products(product.getName(),
									product.getPrice(),
									product.getType())).collect(Collectors.toList());
		
		System.out.println();
		System.out.println("Sorted List of Eatable Products ");
		System.out.println(eatableProductsSorted);

		// sordted by price in ascending order of eatable
		List<Products> sortedByPriceInascendingOrderofEatable=
							 (List<Products>) products.stream().filter(product-> product.getType()=="Eatable")
		                 		.sorted(new Comparator<Products>() {

			@Override
			public int compare(Products o1, Products o2) {
				return (int) (o1.getPrice()-o2.getPrice()) ;
			}
			
		}).collect(Collectors.toList());
		System.out.println();
		System.out.println("Product list of Eatable sorted by price in ascending order");
		System.out.println(sortedByPriceInascendingOrderofEatable);

		// sorted by price in descending order of eatable
		List<Products> sortedByPriceIndescendingOrderofEatable=
							 (List<Products>) products.stream().filter(product-> product.getType()=="Eatable")
		                 		.sorted(new Comparator<Products>() {

			@Override
			public int compare(Products o1, Products o2) {
				return (int) (o2.getPrice()-o1.getPrice()) ;
			}
			
		}).collect(Collectors.toList());
		System.out.println();
		System.out.println("Product list of Eatable sorted by price in descending order");
		System.out.println(sortedByPriceIndescendingOrderofEatable);

		//maximum price of eatable product
		Optional<Products> maximumPriceOfEatable = 
						products.stream().filter(product-> product.getType()=="Eatable")
							.max(Comparator.comparing(Products::getPrice));
		System.out.println();
		System.out.println("Maximum price of Eatable products ");
		System.out.println(maximumPriceOfEatable);

		//minimum price of eatable product
		Optional<Products> minimumPriceOfEatable = 
						products.stream().filter(product-> product.getType()=="Eatable")
							.min(Comparator.comparing(Products::getPrice));
		System.out.println();
		System.out.println("minimum price of Eatable products ");
		System.out.println(minimumPriceOfEatable);

		
	}

}
