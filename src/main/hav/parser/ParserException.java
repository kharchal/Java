package main.hav.parser;

public class ParserException extends Exception {
    private String _err;
	private static final long serialVersionUID = 1L;

	public ParserException(String _err) {
        this._err = _err;
    }
}
