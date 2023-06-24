package RentalService.RentalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rental")
@RestController
public class RentalController {

    RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> Movie(@PathVariable Long id) {
        Movie movie = rentalService.getMovie(id);
        return ResponseEntity.ok(movie);
    }

    @Operation(summary = "Get a movie by its id")
    @ApiResponse(responseCode = "400", description = "Here your Movie")
    @ApiResponse(responseCode = "404", description = "Movie not found",content = @Content)
    @ApiResponse(responseCode = "500", description = "Error",content = @Content)
    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> MovieP(@PathVariable Long id) {
        rentalService.returnMovie(id);
        Movie movie = rentalService.getMovie(id);
        return ResponseEntity.ok(movie);
    }

    @ApiResponse(responseCode = "400", description = "SomeString ok")
    @ApiResponse(responseCode = "404", description = "SomeString not found")
    @ApiResponse(responseCode = "500", description = "blereonienioerni")
    @GetMapping("/hello/{SomeString}")
    public ResponseEntity<String> SomeString(@PathVariable("SomeString") String SomeString) {
        return ResponseEntity.ok(SomeString);
    }
    @PutMapping("/movies/rent/{id}")
    public ResponseEntity<Movie> RentMovie(@PathVariable Long id) {
        rentalService.rentMovie(id);
        Movie movie = rentalService.getMovie(id);
        return ResponseEntity.ok(movie);
    }

}
