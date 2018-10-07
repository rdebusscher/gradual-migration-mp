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
package be.atbash.mp.gradual.mortgage.micro.mortgage;

import be.atbash.mp.gradual.mortgage.micro.blacklist.api.BlacklistResource;
import be.atbash.mp.gradual.mortgage.micro.blacklist.api.BlacklistResponse;
import be.atbash.mp.gradual.mortgage.micro.interest.api.CalculatedInterest;
import be.atbash.mp.gradual.mortgage.micro.interest.api.InterestResource;
import be.atbash.mp.gradual.mortgage.micro.mortgage.api.MortgageDataResponse;
import be.atbash.mp.gradual.mortgage.micro.mortgage.api.MortgageData;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/mortgage")
@ApplicationScoped
public class MortgageService {


    @Inject
    @RestClient
    private BlacklistResource blacklistResource;

    @Inject
    @RestClient
    private InterestResource interestResource;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MortgageDataResponse getInterestValue(MortgageData data) {
        BlacklistResponse mortgageAllowed = blacklistResource.determineMortgageAllowed(data.getName());

        MortgageDataResponse result = null;
        if (mortgageAllowed.isAccepted()) {
            CalculatedInterest calculated = interestResource.getInterestValue(data.getValue(), data.getYears(), 0.0);
            result = new MortgageDataResponse(calculated.getMonths(), calculated.getValue(), calculated.getRate());
        }
        return result;
    }


}
