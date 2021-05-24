package com.adp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class ReadAndWriteFile {
	static List<String> filenames = new LinkedList<String>();
	static int[] buffer;
	private final static Object key = new Object();
	static int count=0;
	static List<Employee> employeeList = new ArrayList<Employee>();
	
	final static File folder = new File("/Desktop/files/");
	
	
	public static void listFilesForFolder(final File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            if(fileEntry.getName().contains(".csv"))
	                filenames.add(fileEntry.getName());
	        }
	    }
	}

	
	
	
	
	public static List<Employee> readFile() throws FileNotFoundException{
		
		for(int p=0;p<filenames.size();p++) {

		Scanner sc = new Scanner(new File(filenames.get(p))); 
		sc.useDelimiter("\n");
		while(sc.hasNext()) {
			/*String line = sc.next();
			Employee employee = new Employee();
			String[] employeeDetails = line.split(",");
			employee.setWorkerId(employeeDetails[0]);
			employee.setFirstName(employeeDetails[1]);
			employee.setLastName(employeeDetails[2]);
			employee.setSSN(employeeDetails[3]);
			employeeList.add(employee);*/
			
		}
		count++;
		}
		
		
		return employeeList;
	}
	
	
	
	public static void writeFile(List<Employee> employeeList) throws IOException {
		FileWriter csvWriter = new FileWriter("new.csv");
		csvWriter.append("WorkerId");
		csvWriter.append(",");
		csvWriter.append("FirstName");
		csvWriter.append(",");
		csvWriter.append("LastName");
		csvWriter.append(",");
		csvWriter.append("SSN");
		csvWriter.append("\n");

		for (int i=0;i<employeeList.size() ;i++) {
			Employee e =employeeList.get(i);
		    csvWriter.append(e.getWorkerId()+","+e.getFirstName()+",");
			//e.getLastName()+","+ e.getSSN());
		    csvWriter.append("\n");
		    count--;
		}

		csvWriter.flush();
		csvWriter.close();
	}

	
	
	static class Producer{
		
		public void produce() throws InterruptedException, FileNotFoundException {
			synchronized(key) {
				if(isFull(employeeList)) {
					key.wait();
				}
				readFile();
				
				key.notify();
			}
			
		}

		private boolean isFull(List<Employee> employeeList) {
			
			return employeeList.size()==count;
		}
		
	}

	
	static class Consumer{
		public void consumes() throws InterruptedException, IOException {
			synchronized(key) {
				if(isEmpty(employeeList)) {
					key.wait();
				}
				writeFile(employeeList);
				key.notify();
			}
			
		}

		private boolean isEmpty(List<Employee> employeeList) {
			return employeeList.size()==0;
		}
	}
	public static void main(String[] args) throws InterruptedException {
		buffer = new int[50];
		count =0;
		
		
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		Runnable folderRead =()->{
			listFilesForFolder(folder);
		};
		Runnable prodRun =()->{
			for(int i=0;i<50;i++) {
				try {
					try {
						producer.produce();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Runnable conRun =()->{
			for(int i=0;i<50;i++) {
				try {
					try {
						consumer.consumes();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread folderReadThread = new Thread(folderRead);
		Thread prodThread = new Thread(prodRun);
		Thread conThread = new Thread(conRun);
		folderReadThread.start();
		prodThread.start();
		conThread.start();
		folderReadThread.join();
		prodThread.join();
		conThread.join();
        System.out.println(count);
	}
	

	

}
