package videos.model.domini;

public class EstatReproduccio {
public enum TipusEstatReproduccio {
	STOP("ATURAT"),
	PAUSE("PAUSA"),
	PLAY("REPRODUCCI�");
	TipusEstatReproduccio(String s) {
		
	}
}

@Override
public String toString() {
	return super.toString();
}

}
