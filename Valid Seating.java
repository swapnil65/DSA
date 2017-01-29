package com.oppLoans.util;

import com.oppLoans.Bean.Person;

class Node {
	Person data;
	Node next;

	public Node(Person data) {
		this.data = data;
	}
}

public class CircularLinkedList {

	public int size = 0;
	public Node head = null;
	public Node tail = null;


	public void addNodeAtEnd(Person newPerson) {
		Node n = new Node(newPerson);
		if (size == 0) {
			head = n;
			tail = n;
			n.next = head;
		} else if(validateSeatingArrangement(head,tail,newPerson)) {
			tail.next = n;
			tail = n;
			tail.next = head;
			size++;
		}
		System.out.println("\nNode " + newPerson + " is added at the end of the list");
	}

	public boolean validateSeatingArrangement(Node head, Node tail, Person newPerson) {
		
		int previousPersonAge = head.data.getAge();
		int nextPersonAge = tail.data.getAge();
		int newPersonAge = newPerson.getAge();
		if(Math.abs(previousPersonAge - newPersonAge) <=5 && Math.abs(nextPersonAge - newPersonAge) <=5) {
			
			if((previousPersonAge < newPersonAge && newPersonAge > nextPersonAge) || (previousPersonAge > newPersonAge && newPersonAge < nextPersonAge)) {
				return true;
			}
		} 
		return false;
	}
	
	public void deleteNode(int Id) {
		if (size == 0) {
			System.out.println("\nTable is Empty");
		} else {
			System.out.println("\ndeleting node " + Id + " from start");
			while(head != tail) {
				if(head.data.getId() == Id) {
					head = head.next;
					tail.next = head;
					size--;
				}
			}
		}
	}

	public void updateNode(Person person) {
		Node temp = head;
		while( temp != head) {
			if(temp.data.getId() == person.getId()){
				temp.data = person;
			}
			temp = temp.next;
		}
	}

	// print the linked list
	public void print() {
		System.out.print("Circular Linked List:");
		Node temp = head;
		if (size <= 0) {
			System.out.print("List is empty");
		} else {
			do {
				System.out.print(" " + temp.data);
				temp = temp.next;
			} while (temp != head);
		}
		System.out.println();
	}

	// get Size
	public int getSize() {
		return size;
	}
}






package com.oppLoans.Bean;

public class Person {
	
	private int Id;
	private String name;
	private int age;
	
	public Person(int Id, String name, int age) {
		super();
		this.Id = Id;
		this.name = name;
		this.age = age;
	}
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Person [Id=" + Id + ", name=" + name + ", age=" + age + "]";
	}

}





package com.oppLoans.Bean;

import com.oppLoans.util.CircularLinkedList;

public class Table {

	private CircularLinkedList table;
	public Table() {
		table = new CircularLinkedList();
	}

	public CircularLinkedList getCurrentStateOfTable() {
		return table;
	}

	public void deleteTable() {
		table = null;
	}

	public Person createPerson(int Id, String name, int age) {
		
		Person person = new Person(Id, name, age);
		table.addNodeAtEnd(person);
		return person;
	}
	
	public void updatePersonName(int Id, String name, int age) {
		
			Person person = new Person(Id, name, age);
			table.updateNode(person);
	}
	
	public void getPerson(int Id) {
		
	}
	
	public void deletePerson(int Id) {		
		table.deleteNode(Id);
	}
}




package com.oppLoans.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TableServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Servlet method responding to HTTP POST methods calls.
	 *
	 * @param request
	 *            HTTP request.
	 * @param response
	 *            HTTP response.
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final PrintWriter out = response.getWriter();
		out.write("GET method (retrieving data) was invoked!");
	}

	/**
	 * Servlet method responding to HTTP POST methods calls.
	 *
	 * @param request
	 *            HTTP request.
	 * @param response
	 *            HTTP response.
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final PrintWriter out = response.getWriter();
		out.write("POST method (changing data) was invoked!");
	}

	/**
	 * Servlet method responding to HTTP PUT methods calls.
	 *
	 * @param request
	 *            HTTP request.
	 * @param response
	 *            HTTP response.
	 */
	@Override
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final PrintWriter out = response.getWriter();
		out.write("PUT method (inserting data) was invoked!");
	}

	/**
	 * Servlet method responding to HTTP DELETE methods calls.
	 *
	 * @param request
	 *            HTTP request.
	 * @param response
	 *            HTTP response.
	 */
	@Override
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final PrintWriter out = response.getWriter();
		out.write("DELETE method (removing data) was invoked!");
	}

	@Override
	public String getServletInfo() {
		return "Server-side application demonstrating HTTP methods.";
	}

}




package com.oppLoans.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oppLoans.Bean.Table;

public class PersonServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Table table = new Table();

	/**
	 * Servlet method responding to HTTP POST methods calls.
	 *
	 * @param request
	 *            HTTP request.
	 * @param response
	 *            HTTP response.
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final PrintWriter out = response.getWriter();
		out.write("GET method (retrieving data) was invoked!");
		table.get
	}

	/**
	 * Servlet method responding to HTTP POST methods calls.
	 *
	 * @param request
	 *            HTTP request.
	 * @param response
	 *            HTTP response.
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final PrintWriter out = response.getWriter();
		out.write("POST method (changing data) was invoked!");
		table.updatePersonName(Id, name, age);
	}

	/**
	 * Servlet method responding to HTTP PUT methods calls.
	 *
	 * @param request
	 *            HTTP request.
	 * @param response
	 *            HTTP response.
	 */
	@Override
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final PrintWriter out = response.getWriter();
		out.write("PUT method (inserting data) was invoked!");
		table.createPerson(Id, name, age);
	}

	/**
	 * Servlet method responding to HTTP DELETE methods calls.
	 *
	 * @param request
	 *            HTTP request.
	 * @param response
	 *            HTTP response.
	 */
	@Override
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final PrintWriter out = response.getWriter();
		out.write("DELETE method (removing data) was invoked!");
		table.deleteNode(request.ge);
	}

	@Override
	public String getServletInfo() {
		return "Server-side application demonstrating HTTP methods.";
	}

}



