package org.jetbrains.kotlin.tests.template

import org.jetbrains.kotlin.generators.generateTestGroupSuiteWithJUnit5
import org.jetbrains.kotlin.test.builders.TestConfigurationBuilder
import org.jetbrains.kotlin.test.directives.DiagnosticsDirectives.RENDER_DIAGNOSTICS_FULL_TEXT
import org.jetbrains.kotlin.test.directives.JvmEnvironmentConfigurationDirectives
import org.jetbrains.kotlin.test.runners.AbstractFirLightTreeDiagnosticsTest
import org.jetbrains.kotlin.test.services.EnvironmentBasedStandardLibrariesPathProvider
import org.jetbrains.kotlin.test.services.KotlinStandardLibrariesPathProvider

abstract class AbstractFirLightTreeTemplateDiagnosticsTest : AbstractFirLightTreeDiagnosticsTest() {
    override fun configure(builder: TestConfigurationBuilder) {
        super.configure(builder)
        builder.commonFirWithPluginFrontendConfiguration()
    }

    override fun createKotlinStandardLibrariesPathProvider(): KotlinStandardLibrariesPathProvider {
        return EnvironmentBasedStandardLibrariesPathProvider
    }
}

fun TestConfigurationBuilder.commonFirWithPluginFrontendConfiguration() {
    defaultDirectives {
        +JvmEnvironmentConfigurationDirectives.FULL_JDK

        +RENDER_DIAGNOSTICS_FULL_TEXT
    }
}

fun main() {
    generateTestGroupSuiteWithJUnit5 {
        testGroup(testDataRoot = "testData", testsRoot = "test-gen") {
            testClass<AbstractFirLightTreeTemplateDiagnosticsTest> {
                model("diagnostics")
            }
        }
    }
}