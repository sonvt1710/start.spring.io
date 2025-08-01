/*
 * Copyright 2012 - present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring.start.site.extension.dependency.lombok;

import io.spring.initializr.generator.buildsystem.DependencyScope;
import io.spring.initializr.generator.buildsystem.gradle.GradleBuild;
import io.spring.initializr.generator.spring.build.BuildCustomizer;
import io.spring.initializr.metadata.Dependency;
import io.spring.initializr.metadata.InitializrMetadata;

/**
 * Complete the setup for Lombok with Gradle by adding Lombok with {@code compileOnly}
 * scope as well.
 *
 * @author Stephane Nicoll
 */
public class LombokGradleBuildCustomizer implements BuildCustomizer<GradleBuild> {

	private final InitializrMetadata metadata;

	public LombokGradleBuildCustomizer(InitializrMetadata metadata) {
		this.metadata = metadata;
	}

	@Override
	public void customize(GradleBuild build) {
		Dependency lombok = this.metadata.getDependencies().get("lombok");
		build.dependencies()
			.add("lombok-compileOnly", lombok.getGroupId(), lombok.getArtifactId(), DependencyScope.COMPILE_ONLY);
	}

}
