/*
 * Copyright 2018 Rudy De Busscher (https://www.atbash.be)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package be.atbash.mp.gradual.mortgage.interest;

import be.atbash.mp.gradual.mortgage.kumuluzee.interest.api.CalculatedInterest;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;


@ApplicationScoped
public class InterestService {

    //https://stackoverflow.com/questions/46813309/weblogic-12-2-1-3-from-moxy-to-jackson

    private Client client;

    private String interestServiceURL;

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();
        interestServiceURL = ConfigProvider.getConfig().getValue("endpoint.interest-service.url", String.class);
    }

    public CalculatedInterest getInterestValue(double value, int years, double rate) {

        Invocation.Builder request = client.target(interestServiceURL)
                .resolveTemplate("value", value)
                .queryParam("years", years)
                .queryParam("rate", rate)
                .request();

        return request.accept(MediaType.APPLICATION_JSON).get().readEntity(CalculatedInterest.class);

    }
}
