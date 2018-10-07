#!/bin/bash
#
# Copyright 2018 Rudy De Busscher (https://www.atbash.be)
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#


java  -jar payara-micro-5.183.jar interest-service/target/interest.war --port 8280 &
java  -jar payara-micro-5.183.jar blacklist-service/target/blacklist.war --port 8180 &
java  -jar payara-micro-5.183.jar mortgage-service/target/mortgage.war --port 8080 &
java  -jar payara-micro-5.183.jar view/target/mortgage-view.war --port 8380