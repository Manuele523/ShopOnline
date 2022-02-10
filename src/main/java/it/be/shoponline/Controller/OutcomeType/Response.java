package it.be.shoponline.Controller.OutcomeType;

import it.be.shoponline.Enum.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private String code;
    private String description;

    public Response(StatusCode status) {
        this.code = status.getCode();
        this.description = status.getDescription();
    }

    public static Response readOutcome(StatusCode status) {
        return new Response(status);
    }
}
