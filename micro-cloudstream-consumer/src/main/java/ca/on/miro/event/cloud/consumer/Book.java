package ca.on.miro.event.cloud.consumer;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@JsonProperty private int id;
	@JsonProperty private String name;
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}
}
