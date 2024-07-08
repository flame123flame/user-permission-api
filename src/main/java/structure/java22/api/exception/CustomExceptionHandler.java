package structure.java22.api.exception;

public class CustomExceptionHandler {
	public class UnauthorizedException extends RuntimeException {
	    private static final long serialVersionUID = 1L;

		public UnauthorizedException(String message) {
	        super(message);
	    }
	}

	public class NotFoundException extends RuntimeException {
	    private static final long serialVersionUID = 1L;

		public NotFoundException(String message) {
	        super(message);
	    }
	}

	
	
}