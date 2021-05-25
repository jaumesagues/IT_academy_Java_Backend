package videos.model.domini;

public class EstatPujada {
public enum TipusEstatPujada {
	UPLOADING("Pujant"), VERIFYING("Verificant"), PUBLIC("Public");	
	TipusEstatPujada(String i){
		
	};
}

@Override
public String toString() {
	return super.toString();
}

}
