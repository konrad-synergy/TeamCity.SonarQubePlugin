<%@ include file="/include-internal.jsp"%>

<%--
  ~ Copyright 2000-2022 JetBrains s.r.o.
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License");
  ~ you may not use this file except in compliance with the License.
  ~ You may obtain a copy of the License at
  ~
  ~ http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing, software
  ~ distributed under the License is distributed on an "AS IS" BASIS,
  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~ See the License for the specific language governing permissions and
  ~ limitations under the License.
  --%>

<table class="runnerFormTable">
    <tr>
        <td colspan="2"><em>Support SonarQube <a href="https://docs.sonarqube.org/latest/branches/overview/" target="_blank"
                rel="noopener noreferrer">Branches</a> and <a href="https://docs.sonarqube.org/latest/analysis/pull-request/" target="_blank"
                rel="noopener noreferrer">Pull-Requests</a> analysis by providing <code>SONARQUBE_SCANNER_PARAMS</code> environment variable (requires
                TeamCity v2019.2 and SonarQube <a href="https://www.sonarsource.com/plans-and-pricing/" target="_blank" rel="noopener noreferrer">Developer
                    Edition or above</a>).
        </em></td>
    </tr>
    <tr>
        <th><label>Provider:<l:star /></label></th>
        <td><props:selectProperty name="provider">
                <props:option value="GitHub">GitHub</props:option>
            </props:selectProperty></td>
    </tr>
</table>