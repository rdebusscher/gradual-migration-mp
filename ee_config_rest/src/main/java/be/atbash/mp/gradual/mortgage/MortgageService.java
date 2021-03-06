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
package be.atbash.mp.gradual.mortgage;

import be.atbash.mp.gradual.mortgage.blacklist.BlacklistResponse;
import be.atbash.mp.gradual.mortgage.blacklist.BlacklistService;
import be.atbash.mp.gradual.mortgage.interest.InterestService;
import be.atbash.mp.gradual.mortgage.kumuluzee.interest.api.CalculatedInterest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MortgageService {

    @Inject
    private BlacklistService blacklistService;

    @Inject
    private InterestService interestService;



    public CalculatedInterest defineMortgage(String name, double value, int years) {
        CalculatedInterest result = null;
        BlacklistResponse blacklistResponse = blacklistService.checkAccepted(name);

        if (blacklistResponse.isAccepted()) {
            result = interestService.getInterestValue(value, years, 0.0);
        }
        return result;
    }
}
