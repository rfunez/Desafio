package desafio.boot.exceptions;

public class AtualizacaoException extends RuntimeException {
	private static final long serialVersionUID=1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Opera�ao permitida apenas para membros funcionarios";
	}
	
	

}
