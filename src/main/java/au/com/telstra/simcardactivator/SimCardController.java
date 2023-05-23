package au.com.telstra.simcardactivator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class SimCardController {

    private static final Logger log = LoggerFactory.getLogger(SimCardController.class);

    @PostMapping({"/activatesimcard"})
    public SimCardRequestStatus handleActuationRequest(@RequestBody SimCardRequest simCardRequest) {

        String iccid = simCardRequest.getIccid();
        String custEmailId = simCardRequest.getCustEmailId();

        SimCardRequestStatus simCardRequestStatus = null;

        if (iccid ==null || custEmailId==null) {
            simCardRequestStatus = new SimCardRequestStatus(false);
        }
        else
        {
            try
            {
                // Create a new  RestTemplate instance
                RestTemplate restTemplate = new RestTemplate();

                // Set the request URL
                String url = "http://localhost:8444/actuate";

                // Set the request headers
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);

                // Create the request body object
                SimCardRequest requestBody = new SimCardRequest(iccid);

                // Convert the request body object to JSON
                ObjectMapper mapper = new ObjectMapper();
                String requestBodyJson = mapper.writeValueAsString(requestBody);

                // Create the HttpEntity with headers and body
                HttpEntity<String> reqEntity = new HttpEntity<>(requestBodyJson, headers);

                // Send the following POST request and get the response
                simCardRequestStatus = restTemplate.postForObject(url, reqEntity, SimCardRequestStatus.class);

            }
            catch (Exception e)
            {
                log.info(e.toString());
            }

        }

        return simCardRequestStatus;
    }

}
