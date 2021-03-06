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

#java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005 -jar payara-micro-5.183.jar interest-service/target/interest.war
java  -jar payara-micro-5.183.jar interest-service/target/interest.war --port 8280