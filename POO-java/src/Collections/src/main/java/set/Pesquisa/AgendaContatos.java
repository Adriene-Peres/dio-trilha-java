package main.java.set.Pesquisa;


import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero){
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos(){
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatoPorNome = new HashSet<>();
        for (Contato c: contatoSet){
            if(c.getNome().startsWith(nome)){
                contatoPorNome.add(c);
            }
        }
        return contatoPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero){
        Contato contatoAtualizado = null;
        for(Contato c: contatoSet){
            if(c.getNome().equalsIgnoreCase(nome)){
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agenda = new AgendaContatos();
        agenda.exibirContatos();
        agenda.adicionarContato("Camila", 123456);
        agenda.adicionarContato("Camila", 0);
        agenda.adicionarContato("Camila Cavalcante", 111111);
        agenda.adicionarContato("Camila DIO", 654987);
        agenda.adicionarContato("Maria Silva", 1111111);

        agenda.exibirContatos();

        System.out.println(agenda.pesquisarPorNome("Camila"));
        System.out.println("Contato atualizado: " + agenda.atualizarNumeroContato("Maria Silva", 5555555));

        agenda.exibirContatos();
    }

}
