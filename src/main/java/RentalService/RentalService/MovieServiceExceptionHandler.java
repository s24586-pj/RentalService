package RentalService.RentalService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MovieServiceExceptionHandler extends ResponseEntityExceptionHandler {

    //HTTP z kodem 404
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handleNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
    }

    //HTTP z kodem 400
    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> handleBadRequestException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
    }

    // odpowiedź HTTP z kodem 502
    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<String> handleInternalServerErrorException() {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Bad Gateway");
    }

    // odpowiedź HTTP z kodem 504
    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<String> handleConnectException() {
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body("Gateway Timeout");
    }
}