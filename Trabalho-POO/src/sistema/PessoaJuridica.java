package sistema;
import grafico.Desktop;

import javax.swing.*;

import banco.BD;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.*;
public abstract class PessoaJuridica extends JPanel{
	public int pessoa_id;
	public String razaoSocialVal;
	public String nomeFantasiaVal;
	public long cnpjVal;
	public long telefoneVal;
	public boolean statusVal;
	public Endereco endereco;
	
	
	public PessoaJuridica(ArrayList<String> M){
		this.pessoa_id=Integer.parseInt(M.get(0));
		this.razaoSocialVal=M.get(1);
		this.nomeFantasiaVal = M.get(2);
		this.cnpjVal=Long.parseLong(M.get(3));
		this.telefoneVal=Long.parseLong(M.get(4));
		this.statusVal=Boolean.parseBoolean(M.get(5));
		this.endereco=new Endereco(M.get(6), Integer.parseInt(M.get(7)), M.get(8),M.get(9),M.get(10),M.get(11));
	}
	public static JPanel[] getPanels(){
		JPanel backListPanel = new JPanel();
		
		JPanel frontListPanel = new JPanel();
		JPanel productList = new JPanel();
		ArrayList<ArrayList<String>> ps = Desktop.banco.lerArquivo("PessoaFisica");

		productList.setLayout(new GridLayout((ps.size()+1),6,10,4));
		productList.add(new JLabel("Razao Social"));
		productList.add(new JLabel("Nome Fantasia"));
		productList.add(new JLabel("CNPJ"));
		productList.add(new JLabel("Telefone"));
		productList.add(new JLabel("Endereco"));
		productList.add(new JLabel("Status 0-Inativo 1-Ativo"));
		for(int x=0; x<ps.size(); x++){
			for(int y=0;y<6;y++){
				productList.add(new JLabel(ps.get(x).get(y)));
			}
		}
		backListPanel.add(frontListPanel);
		frontListPanel.add(productList);
		
		
		JPanel castPanel = new JPanel();
		
		JPanel PessoaJuridica = new ClienteJuridico();
		JPanel PessoaJuridica2 = new Fornecedor();
		castPanel.add(PessoaJuridica);
		castPanel.add(PessoaJuridica2);
		JPanel [] p = { backListPanel, castPanel };
		return p;
		
	}
		
	public PessoaJuridica(){
	}
		
}
	