package models;

import static com.google.common.base.MoreObjects.toStringHelper;
import com.google.common.base.Objects;


public class Rating {
	public Long userID=0L;
	public Long movieID=0L;
	public long id=0L;
	static long counter = 01L;
	public float newRating=0;
	
	public Rating(){
		
	}

	public Rating(long userID, long movieID, float newRating) {
		this.userID = userID;
		this.movieID = movieID;
		this.newRating=newRating;
		this.id=counter++;
		
	}
	@Override
	public String toString() {
		return toStringHelper(this).addValue(id).addValue(userID).addValue(movieID).addValue(newRating).toString();
	}
	@Override
	public int hashCode() {
	return Objects.hashCode(this.userID, this.movieID, this.newRating,this.id);
	}
	@Override
	public boolean equals(final Object obj){
		if(obj instanceof Rating)
		{final Rating other=(Rating)obj;
		return Objects.equal(userID, other.userID)
				&&Objects.equal(movieID,other.movieID)
				&&Objects.equal(newRating, other.newRating);
		}else{
			return false;
			
		}
	}
}

