public class Propriedades{
	private String name;
	private String type;
	private String changeAccess;


	// Construtor vazio
	public Propriedades() {
	}

	// Construtor com todos os campos
	public Propriedades(String name, String type, String changeAccess) {
		this.name = name;
		this.type = type;
		this.changeAccess = changeAccess;
	}	


	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return this.type;
	}
	public void setChangeAccess(String changeAccess){
		this.changeAccess = changeAccess;
	}
	public String getChangeAccess(){
		return this.changeAccess;
	}


	// Método toString
	@Override
	public String toString() {
		return "Propriedades{" +
			"name='" + name + '\'' +
			", type='" + type + '\'' +
			", changeAccess='" + changeAccess + '\'' +
			'}';
	}





}
