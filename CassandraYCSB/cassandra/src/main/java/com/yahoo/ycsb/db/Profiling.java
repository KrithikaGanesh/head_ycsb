package com.yahoo.ycsb.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;

public class Profiling
{
	static final AtomicInteger numRead = new AtomicInteger(0);
	static final AtomicInteger numWrite= new AtomicInteger(0);
	static final AtomicInteger numScan= new AtomicInteger(0);
	static final AtomicInteger totalNum = new AtomicInteger(0);
	private static Logger logger = LoggerFactory.getLogger(Profiling.class);
	
	public static int incrementAndGetRead()
	{	
		numRead.incrementAndGet();
		logger.debug("Number of reads happening right now " + numRead.get());
		return numRead.get();
	}
	public static int incrementAndGetWrite()
	{
		numWrite.incrementAndGet();
		return numWrite.get();
	}
	public static int incrementAndGetScan()
	{
		numScan.incrementAndGet();
		return numScan.get();
	}

			 
	public static int decrementRead()
	{
		numRead.decrementAndGet();
		logger.debug("Number of reads happening right now (in decrement) " + numRead.get());
		return numRead.get();
	}
	public static int decrementScan()
	{
		numScan.decrementAndGet();
		return numScan.get();
	}
	public static int decrementWrite()
	{
		numWrite.decrementAndGet();
		return numWrite.get();
	}
	public static void writeToFile(int tag, int currentops)
	{
		logger.debug("Going to Write to file");
		if (tag==1) //1 is for read 
		{
	        	try
			{
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/root/YCSBRead", true))) ;
				totalNum.incrementAndGet();
				out.println(currentops);
				logger.debug("current ops" + currentops);
				out.close();
				logger.debug("Write Worked in Thrift");
		  	}
			catch (IOException e)
			{
				logger.debug("FILE ISSUE");
			}
		}
		else if (tag==2) //2 is for write
		{
	        	try
			{
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/root/YCSBWrite", true))) ;
				out.println(currentops);
				out.close();
				logger.debug("Write Worked in Thrift");
		  	}
			catch (IOException e)
			{
				logger.debug("FILE ISSUE");
			}
		}
		else if (tag==3) //3 is for scan 
		{
	        	try
			{
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/root/YCSBScan", true))) ;
				out.println(currentops);
				out.close();
				logger.debug("Write Worked in Thrift");
		  	}
			catch (IOException e)
			{
				logger.debug("FILE ISSUE");
			}
		}
	}

}

