package interface_adapter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseController<T, R> {
    public abstract ResponseEntity<R> executeImpl(@RequestBody T request);

    public void execute(T request) {
        try{
            executeImpl(request);
        } catch(Exception e){
            ResponseEntity.internalServerError().body(null);
        }
    }
}
