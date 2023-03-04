package com.example.demo;

import com.example.demo.exceptions.UnsupportrdMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculadora {

    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportrdMathOperationException("Insira um valor numerico");
        }
        return covertToDouble(numberOne) + covertToDouble(numberTwo);
    }

    @RequestMapping(value="/sub/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportrdMathOperationException("Insira um valor numerico");
        }
        return covertToDouble(numberOne) - covertToDouble(numberTwo);
    }

    @RequestMapping(value="/mult/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double mult(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportrdMathOperationException("Insira um valor numerico");
        }
        return covertToDouble(numberOne) * covertToDouble(numberTwo);
    }

    @RequestMapping(value="/div/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportrdMathOperationException("Insira um valor numerico");
        }
        return covertToDouble(numberOne) / covertToDouble(numberTwo);
    }

    @RequestMapping(value="/media/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double media(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportrdMathOperationException("Insira um valor numerico");
        }
        return (covertToDouble(numberOne) + covertToDouble(numberTwo)) / 2;
    }

    @RequestMapping(value="/raiz/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double raiz(@PathVariable("numberOne") String numberOne) throws Exception {

        if (!isNumeric(numberOne)) {
            throw new UnsupportrdMathOperationException("Insira um valor numerico");
        }
        return Math.sqrt(covertToDouble(numberOne));
    }

    public static Double covertToDouble(String strNumber) {
        if (strNumber == null) return 0d;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 1.0d;
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
        //return false;
    }
}
