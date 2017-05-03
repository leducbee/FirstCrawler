package com.crawler.bee;

public class MainCrawler {
	/**
	 * This is our test. It creates a spider (which creates spider legs) and
	 * crawls the web.
	 * 
	 * @param args
	 *            - not used
	 */
	public static void main(String[] args) {
		Spider spider = new Spider();
		spider.search("http://www.pokemonspecial.com/2014/06/chapter-499-vs-scraggy.html");//362
	}
}
