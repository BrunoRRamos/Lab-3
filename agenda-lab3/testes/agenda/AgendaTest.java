package agenda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    private Agenda agenda;

    @BeforeEach
    void preparaContatos() {
        agenda.cadastraContato(2, "Bruno", "Rodrigues", "(83) 2233-4432");
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "555-5551");
    }
    @Test
    void retornaContatoInfoTest() {
        String msg = "Retorna nome, sobrenome e número";
        assertEquals("Matheus Gaudencio\n555-5551", agenda.retornaContatoInfo(1));
        assertEquals("POSIÇÃO INVÁLIDA!", agenda.retornaContatoInfo(43));
    }

    @Test
    void cadastraContato() {
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