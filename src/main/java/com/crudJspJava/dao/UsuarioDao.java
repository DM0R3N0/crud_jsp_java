package com.crudJspJava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudJspJava.bean.Usuario;


public class UsuarioDao {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudjspjava","root","sophia01");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return con; 
	}  
public static List<Usuario> getAllUsuarios(){
	
	//String sql = "SELECT * FROM contatos";	
	List<Usuario> list = new ArrayList<Usuario>();

	try {
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("select * from usuario");
	//Classe que vai recuperar os dados do banco. ***SELECT****
	ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			
			Usuario usuario = new Usuario();
			
			//Recuperar o id
			usuario.setId(rs.getInt("id"));
			//Recuperar o nome
			usuario.setNome(rs.getString("nome"));
			//Recuperar o password
			usuario.setPassword(rs.getString("password"));
			//Recuperar o email
			usuario.setEmail(rs.getString("email"));
			//Recuperar o sexo
			usuario.setSexo(rs.getString("sexo"));
			//Recuperar o país
			usuario.setPais(rs.getString("pais"));
			
			list.add(usuario);
			
		}
	}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
}

public static Usuario getRegistroById(int id) {
	Usuario usuario = null;
	
	try {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			usuario=new Usuario();
			//Recuperar o id
			usuario.setId(rs.getInt("id"));
			//Recuperar o nome
			usuario.setNome(rs.getString("nome"));
			//Recuperar o password
			usuario.setPassword(rs.getString("password"));
			//Recuperar o email
			usuario.setEmail(rs.getString("email"));
			//Recuperar o sexo
			usuario.setSexo(rs.getString("sexo"));
			//Recuperar o país
			usuario.setPais(rs.getString("pais"));
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	
	return usuario;
	
}

}

