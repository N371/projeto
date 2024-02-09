import java.sql.*;

public class conexaoBancoDados{
	Connection conBanco;
        private String projeto;
        private String user;
        private String password;

        public void setProjeto(String projeto){
		this.projeto = projeto;
	}
	public void setUser(String user){
		this.user = user;
	}
        public void setPassword(String password){
		this.password = password;
	}
        public String getProjeto(){
		return(this.projeto);
	}
	public String getUser(){
		return(this.user);
	}
	public String getPassword(){
		return(this.password);
	}

	public boolean abrirConexao(){
		String url = "jdbc:mysql://localhost/" + getProjeto + "?user=" + getUser + "root&password=" + getPassword + "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
     			conBanco = DriverManager.getConnection(url);
			return true;
                    }catch(Exception erro){
			erro.printStackTrace();
 			return false;
		    }
        }  
	public boolean fecharConexao(){
		try{
			conBanco.close();
			return true;
		}catch(Exception erro){
			erro.printStackTrace();
			return false;
		}
           }
	public Connection obterConexao() {return conBanco;};
     }




