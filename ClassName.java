public class ClassName{

private String nome;
private String sexo;
private Integer Idade;
protected Floar sari;

public ClassName( String nome, String sexo, Integer Idade, Floar sari)
{
this.nome = nome;
this.sexo = sexo;
this.Idade = Idade;
this.sari = sari;
}
public ClassName(){
}
public void setnome(String nome) {
      this.nome=nome;
}
public void setsexo(String sexo) {
      this.sexo=sexo;
}
public void setIdade(Integer Idade) {
      this.Idade=Idade;
}
public void setsari(Floar sari) {
      this.sari=sari;
}
public String getnome() {
      return this.nome;
}
public String getsexo() {
      return this.sexo;
}
public Integer getIdade() {
      return this.Idade;
}
public Floar getsari() {
      return this.sari;
}
@Override
 public String toString(){
 return "ClassName{" + "nome=" + nome+"sexo=" + sexo+"Idade=" + Idade+"sari=" + sari + '}';
}
}