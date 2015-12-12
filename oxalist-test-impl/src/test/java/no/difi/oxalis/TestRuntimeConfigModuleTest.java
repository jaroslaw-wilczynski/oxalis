/*
 * Copyright (c) 2010 - 2015 Norwegian Agency for Pupblic Government and eGovernment (Difi)
 *
 * This file is part of Oxalis.
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they will be approved by the European Commission
 * - subsequent versions of the EUPL (the "Licence"); You may not use this work except in compliance with the Licence.
 *
 * You may obtain a copy of the Licence at:
 *
 * https://joinup.ec.europa.eu/software/page/eupl5
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the Licence
 *  is distributed on an "AS IS" basis,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the Licence for the specific language governing permissions and limitations under the Licence.
 *
 */

package no.difi.oxalis;

import com.google.inject.*;
import eu.peppol.util.GlobalConfiguration;
import jdk.nashorn.internal.objects.Global;
import org.testng.annotations.Test;

import java.io.File;

import static org.junit.Assert.assertNotNull;

/**
 * @author steinar
 *         Date: 12.12.2015
 *         Time: 00.53
 */
public class TestRuntimeConfigModuleTest {

    @Test
    public void createSampleInstance() throws Exception {

        Injector injector = Guice.createInjector(new TestModule());
        GlobalConfiguration instance = injector.getInstance(GlobalConfiguration.class);
        File oxalisHomeDir = instance.getOxalisHomeDir();
        assertNotNull(oxalisHomeDir);

    }

    public static class TestModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(GlobalConfiguration.class).to(GlobalTestConfigurationImpl.class);
        }
    }

}