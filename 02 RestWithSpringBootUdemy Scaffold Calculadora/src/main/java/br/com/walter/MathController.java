package br.com.walter;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.walter.exception.NoMathOperationException;

@RestController
public class MathController {
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {	
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new NoMathOperationException("Please set a numeric value");
		}
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;	
	}
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {	
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new NoMathOperationException("Please set a numeric value");
		}
		Double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return sub;	
	}
	
	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {	
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new NoMathOperationException("Please set a numeric value");
		}
		Double mult = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return mult;	
	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {	
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new NoMathOperationException("Please set a numeric value");
		}
		Double div = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return div;	
	}
	
	@RequestMapping(value = "/quad/{numberOne}", method=RequestMethod.GET)
	public Double quad(@PathVariable(value = "numberOne") String numberOne) throws Exception {	
		
		if (!isNumeric(numberOne)) {
			throw new NoMathOperationException("Please set a numeric value");
		}
		Double div = convertToDouble(numberOne);
		return Math.sqrt(div);
	}
	

	private Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		strNumber = strNumber.replace(",", ".");
		
		if(isNumeric(strNumber)) {
			return Double.parseDouble(strNumber);
		}
		
		return 0D;
	}

	private boolean isNumeric(String strNumber) {	
		if (strNumber == null) return false;
		strNumber = strNumber.replace(",", ".");
		return strNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
}
