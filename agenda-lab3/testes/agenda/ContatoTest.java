package agenda;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class ContatoTest {

    private Contato contatoBase;

    @BeforeEach
    void preparaContatos() {
        this.contatoBase = new Contato("Matheus", "Gaudencio", "555-5551");
    }

    @Test
    void nomeCompletoTest() {
        String msg = "Esperando obter o nome completo";
        assertEquals("Matheus Gaudencio", this.contatoBase.nomeCompleto());
    }

    @Test
    void favoritaContatoTest() {
        contatoBase.favoritaContato();
        assertTrue(contatoBase.getFavorito());
    }

    @Test
    void desfavoritaContatoTest() {
        contatoBase.favoritaContato();
        contatoBase.desfavoritaContato();
        assertFalse(contatoBase.getFavorito());
    }

    @Test
    void toStringTest() {
        String infos = contatoBase.toString();
        assertEquals("Matheus Gaudencio\n555-5551", this.contatoBase.toString());
    }

    @Test
    void toStringFavTest() {
        contatoBase.favoritaContato();
        String infos = contatoBase.toString();
        assertEquals("❤ Matheus Gaudencio\n555-5551", this.contatoBase.toString());
    }
}