package agenda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    private Agenda agenda = new Agenda();
    private Throwable exception;

    @BeforeEach
    void preparaContatos() {
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "555-5551");
        agenda.cadastraContato(2, "Bruno", "Rodrigues", "(83) 2233-4432");
        agenda.cadastraContato(10, "David", "Nóbrega", "1010-2020");
    }
    @Test
    void retornaContatoInfoTest() {
        agenda.cadastraContato(100, "Mike", "Souza", "3344-2020");
        assertEquals("Mike Souza\n3344-2020", agenda.retornaContatoInfo(100));
        assertEquals("Matheus Gaudencio\n555-5551", agenda.retornaContatoInfo(1));
        assertEquals("Bruno Rodrigues\n(83) 2233-4432", agenda.retornaContatoInfo(2));
        assertEquals("POSIÇÃO INVÁLIDA!", agenda.retornaContatoInfo(43));
        assertEquals("POSIÇÃO INVÁLIDA!", agenda.retornaContatoInfo(-23));
        assertEquals("POSIÇÃO INVÁLIDA!", agenda.retornaContatoInfo(101));
        assertEquals("POSIÇÃO INVÁLIDA!", agenda.retornaContatoInfo(0));
        agenda.cadastraFavorito(100, 1);
        assertEquals("❤ Mike Souza\n3344-2020", agenda.retornaContatoInfo(100));
    }

    @Test
    void cadastraContatoTest() {
        agenda.cadastraContato(3, "Pedro", "Maia", "(32) 3332-3254");
        agenda.cadastraContato(100, "Jonas", "Huts", "(34) 4039-8654");
        agenda.cadastraContato(1, "Júlio", "Marques", "3344-5567");
        assertEquals("Pedro Maia\n(32) 3332-3254", agenda.retornaContatoInfo(3));
        assertEquals("Jonas Huts\n(34) 4039-8654", agenda.retornaContatoInfo(100));
        assertEquals("Júlio Marques\n3344-5567", agenda.retornaContatoInfo(1));

        agenda.cadastraContato(3, "Maria", "Silva", "3344-6754");
        assertEquals("Maria Silva\n3344-6754", agenda.retornaContatoInfo(3));
    }

    @Test
    void cadastraContatoTestExceptions() {
        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            agenda.cadastraContato(0, "Selma", "", "2244-5543");
        });
        assertEquals("POSIÇÃO INVALIDA", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.cadastraContato(-12, "Selma", "", "2244-5543");
        });
        assertEquals("POSIÇÃO INVALIDA", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.cadastraContato(101, "Selma", "", "2244-5543");
        });
        assertEquals("POSIÇÃO INVALIDA", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.cadastraContato(3, "Pedro", "Maia", "(32) 3332-3254");
            agenda.cadastraContato(4, "Pedro", "Maia", "(32) 3332-3254");
        });
        assertEquals("CONTATO JA CADASTRADO", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.cadastraContato(5, "", "Pereira", "(32) 4345-4456");
        });
        assertEquals("CONTATO INVALIDO", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.cadastraContato(5, "Joana", "Pereira", "");
        });
        assertEquals("NUMERO INVALIDO", exception.getMessage());
    }

    @Test
    void cadastraFavoritoTest() {
        agenda.cadastraFavorito(2, 1);
        assertEquals("❤ Bruno Rodrigues\n(83) 2233-4432", agenda.retornaContatoInfo(2));
    }

    @Test
    void cadastraFavoritosTestExceptions() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.cadastraFavorito(2, 1);
            agenda.cadastraFavorito(2, 1);
        });
        assertEquals("JA FOI FAVORITADO", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.cadastraFavorito(45, 2);
        });
        assertEquals("POSIÇÃO INVALIDA", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.cadastraFavorito(1, -23);
        });
        assertEquals("POSIÇÃO INVALIDA", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.cadastraFavorito(1, 11);
        });
        assertEquals("POSIÇÃO INVALIDA", exception.getMessage());
    }

    @Test
    void returnListaContatosTest() {
        assertEquals("1 - Matheus Gaudencio\n2 - Bruno Rodrigues\n10 - David Nóbrega\n", agenda.returnListaContatos());
    }

    @Test
    void returnFavoritosTest() {
        assertEquals("NENHUM FAVORITO", agenda.returnFavoritos());
        agenda.cadastraFavorito(1, 1);
        agenda.cadastraFavorito(2, 2);
        agenda.cadastraFavorito(10, 3);
        assertEquals("1 - Matheus Gaudencio\n2 - Bruno Rodrigues\n3 - David Nóbrega\n", agenda.returnFavoritos());
    }

    @Test
    void removeFav() {
        agenda.cadastraFavorito(2, 1);
        assertEquals("❤ Bruno Rodrigues\n(83) 2233-4432", agenda.retornaContatoInfo(2));
        agenda.removeFav(1);
        assertEquals("Bruno Rodrigues\n(83) 2233-4432", agenda.retornaContatoInfo(2));

    }
}