package structure.java22.api.core.model;

import lombok.Data;

@Data
public class DatatableFilter {

	private String column;
	private String value;
	private String op;

	public DatatableFilter(String column, String op, String value) {
		// TODO Auto-generated constructor stub
		this.op = op;
		this.value = value;
		this.column = column;
	}
}
