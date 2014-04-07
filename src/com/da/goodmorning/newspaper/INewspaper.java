package com.da.goodmorning.newspaper;

public interface INewspaper {
	public NewspaperProperties newspaperProps = new NewspaperProperties();
	
	public NewspaperProperties getNewspaperProps();
	
	void notifyDataSetChanged();
}
