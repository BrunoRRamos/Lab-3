package agenda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    private Agenda agenda = new Agenda();

    @BeforeEach
    void preparaContatos() {
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "555-5551");
        agenda.cadastraContato(2, "Bruno", "Rodrigues", "(83) 2233-4432");
    }
    @Test
    void retornaContatoInfoTest() {
        String msg = "Retorna nome, sobrenome e número";
        assertEquals("Matheus Gaudencio\n555-5551", agenda.retornaContatoInfo(1));
        assertEquals("Bruno Rodrigues\n(83) 2233-4432", agenda.retornaContatoInfo(2));
        assertEquals("POSIÇÃO INVÁLIDA!", agenda.retornaContatoInfo(43));
        assertEquals("POSIÇÃO INVÁLIDA!", agenda.retornaContatoInfo(-23));
        assertEquals("POSIÇÃO INVÁLIDA!", agenda.retornaContatoInfo(101));
    }

    @Test
    void cadastraContato() {
        String msg = "Cadastra um contato";
        agenda.cadastraContato(3, "Pedro", "Maia", "(32) 3332-3254");
        assertEquals("Pedro Maia\n(32) 3332-3254", agenda.retornaContatoInfo(3));
    }

    @Test
    void cadastraFavorito() {
    }

    @Test
    void verificaNomeContato() {
    }

    @Test
    void getListaContatos() {
    }

    @Test
    void getFavoritos() {
    }

    @Test
    void removeFav() {
    }
}