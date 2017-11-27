/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.0-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import java.util.Map;
import io.swagger.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Api(value = "store", description = "the store API")
public interface StoreApi {

    Logger log = LoggerFactory.getLogger(StoreApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Delete purchase order by ID", nickname = "deleteOrder", notes = "For valid response try integer IDs with value < 1000. Anything above 1000 or nonintegers will generate API errors", tags={ "store", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Order not found") })
    @RequestMapping(value = "/store/order/{order_id}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.DELETE)
    default CompletableFuture<ResponseEntity<Void>> deleteOrder(@ApiParam(value = "ID of the order that needs to be deleted",required=true) @PathVariable("order_id") String orderId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default StoreApi interface so no example is generated");
        }
        return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
    }


    @ApiOperation(value = "Returns pet inventories by status", nickname = "getInventory", notes = "Returns a map of status codes to quantities", response = Integer.class, responseContainer = "Map", authorizations = {
        @Authorization(value = "api_key")
    }, tags={ "store", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Map.class, responseContainer = "Map") })
    @RequestMapping(value = "/store/inventory",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default CompletableFuture<ResponseEntity<Map<String, Integer>>> getInventory() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return CompletableFuture.completedFuture(new ResponseEntity<>(getObjectMapper().get().readValue("{  \"key\" : 0}", Map.class), HttpStatus.NOT_IMPLEMENTED));
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default StoreApi interface so no example is generated");
        }
        return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
    }


    @ApiOperation(value = "Find purchase order by ID", nickname = "getOrderById", notes = "For valid response try integer IDs with value <= 5 or > 10. Other values will generated exceptions", response = Order.class, tags={ "store", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Order.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Order not found") })
    @RequestMapping(value = "/store/order/{order_id}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    default CompletableFuture<ResponseEntity<Order>> getOrderById(@Min(1) @Max(5) @ApiParam(value = "ID of pet that needs to be fetched",required=true) @PathVariable("order_id") Long orderId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/xml")) {
                try {
                    return CompletableFuture.completedFuture(new ResponseEntity<>(getObjectMapper().get().readValue("<Order>  <id>123456789</id>  <petId>123456789</petId>  <quantity>123</quantity>  <shipDate>2000-01-23T04:56:07.000Z</shipDate>  <status>aeiou</status>  <complete>true</complete></Order>", Order.class), HttpStatus.NOT_IMPLEMENTED));
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/xml", e);
                    return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
                }
            }
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return CompletableFuture.completedFuture(new ResponseEntity<>(getObjectMapper().get().readValue("{  \"id\" : 0,  \"petId\" : 6,  \"complete\" : false,  \"status\" : \"placed\",  \"quantity\" : 1,  \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\"}", Order.class), HttpStatus.NOT_IMPLEMENTED));
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default StoreApi interface so no example is generated");
        }
        return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
    }


    @ApiOperation(value = "Place an order for a pet", nickname = "placeOrder", notes = "", response = Order.class, tags={ "store", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Order.class),
        @ApiResponse(code = 400, message = "Invalid Order") })
    @RequestMapping(value = "/store/order",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.POST)
    default CompletableFuture<ResponseEntity<Order>> placeOrder(@ApiParam(value = "order placed for purchasing the pet" ,required=true )  @Valid @RequestBody Order body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/xml")) {
                try {
                    return CompletableFuture.completedFuture(new ResponseEntity<>(getObjectMapper().get().readValue("<Order>  <id>123456789</id>  <petId>123456789</petId>  <quantity>123</quantity>  <shipDate>2000-01-23T04:56:07.000Z</shipDate>  <status>aeiou</status>  <complete>true</complete></Order>", Order.class), HttpStatus.NOT_IMPLEMENTED));
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/xml", e);
                    return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
                }
            }
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return CompletableFuture.completedFuture(new ResponseEntity<>(getObjectMapper().get().readValue("{  \"id\" : 0,  \"petId\" : 6,  \"complete\" : false,  \"status\" : \"placed\",  \"quantity\" : 1,  \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\"}", Order.class), HttpStatus.NOT_IMPLEMENTED));
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default StoreApi interface so no example is generated");
        }
        return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
    }

}
