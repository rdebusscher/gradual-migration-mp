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
package be.atbash.mp.gradual.mortgage.micro.blacklist;


import be.atbash.mp.gradual.mortgage.micro.blacklist.api.BlacklistResource;
import be.atbash.mp.gradual.mortgage.micro.blacklist.api.BlacklistResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;
import java.util.Locale;

@Path("/blacklist")
@ApplicationScoped
public class BlacklistService implements BlacklistResource {

    @Override
    public BlacklistResponse determineMortgageAllowed(String name) {
        if (name.toLowerCase(Locale.ENGLISH).contains("rudy")) {
            return new BlacklistResponse(false);
        }
        return new BlacklistResponse(true);
    }
}
