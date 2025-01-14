/*
 * Copyright 2000-2022 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jetbrains.buildserver.sonarplugin;

import jetbrains.buildServer.util.OSType;
import jetbrains.buildServer.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static jetbrains.buildServer.util.OSType.WINDOWS;

public class SQScannerArgsComposer implements SQArgsComposer {
    @NotNull
    private final OSType myOsType;

    public SQScannerArgsComposer(@NotNull final OSType osType) {
        myOsType = osType;
    }

    @Override
    public List<String> composeArgs(@NotNull final SQRParametersAccessor accessor,
                                    @NotNull final SonarQubeKeysProvider keys) {
        final List<String> res = new LinkedList<String>();
        addSQRArg(res, keys.getProjectHome(), accessor.getProjectHome(), myOsType);
        addSQRArg(res, keys.getHostUrl(), accessor.getHostUrl(), myOsType);
        addSQRArg(res, keys.getJdbcUrl(), accessor.getJDBCUrl(), myOsType);
        addSQRArg(res, keys.getJdbcUsername(), accessor.getJDBCUsername(), myOsType);
        addSQRArg(res, keys.getJdbcPassword(), accessor.getJDBCPassword(), myOsType);
        addSQRArg(res, keys.getProjectKey(), SQRBuildService.getProjectKey(accessor.getProjectKey()), myOsType);
        addSQRArg(res, keys.getProjectName(), accessor.getProjectName(), myOsType);
        addSQRArg(res, keys.getProjectVersion(), accessor.getProjectVersion(), myOsType);
        addSQRArg(res, keys.getSources(), accessor.getProjectSources(), myOsType);
        addSQRArg(res, keys.getTests(), accessor.getProjectTests(), myOsType);
        addSQRArg(res, keys.getBinaries(), accessor.getProjectBinaries(), myOsType);
        addSQRArg(res, keys.getJavaBinaries(), accessor.getProjectBinaries(), myOsType);
        addSQRArg(res, keys.getModules(), accessor.getProjectModules(), myOsType);
        if (accessor.getToken() != null) {
            addSQRArg(res, keys.getLogin(), accessor.getToken(), myOsType);
        } else {
            addSQRArg(res, keys.getPassword(), accessor.getPassword(), myOsType);
            addSQRArg(res, keys.getLogin(), accessor.getLogin(), myOsType);
        }
        final String additionalParameters = accessor.getAdditionalParameters();
        if (additionalParameters != null) {
            res.addAll(Arrays.asList(additionalParameters.split("\\n")));
        }

        return res;
    }

    protected static void addSQRArg(@NotNull final List<String> argList, @Nullable final String key, @Nullable final String value, @NotNull final OSType osType) {
        if (Util.isEmpty(value) || Util.isEmpty(key)) {
            return;
        }
        final String paramValue = key + value;
        argList.add(osType == WINDOWS ? StringUtil.doubleQuote(StringUtil.escapeQuotes(paramValue)) : paramValue);
    }
}
