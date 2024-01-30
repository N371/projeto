
private String nome;
private String sexo;
private Integer idade;

public ClassName( String nome, String sexo, Integer idade)
{
this.nome = nome;
this.sexo = sexo;
this.idade = idade;
}
public ClassName(){
}
public void setnome(String nome) {
      this.nome=nome;
}
public void setsexo(String sexo) {
      this.sexo=sexo;
}
public void setidade(Integer idade) {
      this.idade=idade;
}
public String getnome() {
      return this.nome;
}
public String getsexo() {
      return this.sexo;
}
public Integer getidade() {
      return this.idade;
}
@Override
 public String toString(){
 return "ClassName{" + "nome=" + nome+"sexo=" + sexo+"idade=" + idade + '}';
}
}

