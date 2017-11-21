package models;


import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.google.common.base.Objects;

public class Movie {

	public String title;
	public String year;
	public String url;
	static long counter = 01L;
	public long id=01L;
	
	public Map<Long,Rating> rating = new HashMap<>();
	public List<Rating> movieArray=new ArrayList<>();
	
	public Movie(){
		
	}

	public Movie(String title, String year, String url) {
		this.title = title;
		this.year = year;
		this.url = url;
		this.id = counter++;
	}

	@Override
	public String toString() {
		return toStringHelper(this).addValue(id).addValue(title).addValue(year).addValue(url).addValue(movieArray).toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.id,this.title, this.year, this.url);
	}
	
	@Override
	public boolean equals(final Object obj){
		if(obj instanceof Movie)
		{
			final Movie other=(Movie)obj;
			return Objects.equal(title, other.title)
					&&Objects.equal(year, other.year)
					&&Objects.equal(url, other.url)
					&&Objects.equal(movieArray, other.movieArray);
		}
		else{
			return false;
		}
	}
}
