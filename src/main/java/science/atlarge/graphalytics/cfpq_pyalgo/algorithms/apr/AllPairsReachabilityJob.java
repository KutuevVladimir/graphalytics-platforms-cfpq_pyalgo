/*
 * Copyright 2015 Delft University of Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package science.atlarge.graphalytics.cfpq_pyalgo.algorithms.bfs;

import science.atlarge.graphalytics.domain.algorithms.AlgorithmParameters;
import science.atlarge.graphalytics.domain.algorithms.BreadthFirstSearchParameters;
import science.atlarge.graphalytics.execution.RunSpecification;
import science.atlarge.graphalytics.domain.benchmark.BenchmarkRun;
import science.atlarge.graphalytics.cfpq_pyalgo.CFPQ_PyAlgoJob;
import science.atlarge.graphalytics.cfpq_pyalgo.CFPQ_PyAlgoConfiguration;

/**
 * All-pairs reachability job implementation for CFPQ_PyAlgo. This class is responsible for formatting BFS-specific
 * arguments to be passed to the platform executable, and does not include the implementation of the algorithm.
 *
 * @author Kutuev Vladimir
 */
public final class AllPairsReachabilityJob extends CFPQ_PyAlgoJob {

	private final long grammarPath;

	/**
	 * Creates a new AllPairsReachabilityJob object with all mandatory parameters specified.
	 *
	 * @param platformConfig the platform configuration.
	 * @param inputPath the path to the input graph.
	 */
	public AllPairsReachabilityJob(RunSpecification runSpecification, CFPQ_PyAlgoConfiguration platformConfig,
								 String inputPath, String outputPath) {
		super(runSpecification, platformConfig, inputPath, outputPath);

		AlgorithmParameters parameters = runSpecification.getBenchmarkRun().getAlgorithmParameters();
		this.grammarPath = ((AllPairsReachabilityParameters)parameters).getGrammarPath(); //to do in core
	}

	@Override
	protected void appendAlgorithmParameters() {

		commandLine.addArgument("--algorithm");
		commandLine.addArgument("apr");

		commandLine.addArgument("--grammar-path", false);
		commandLine.addArgument(String.valueOf(grammarPath), false);
	}
}
