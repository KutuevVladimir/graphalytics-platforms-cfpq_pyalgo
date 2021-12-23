import sys
from pathlib import Path

cfpq_pyalgo_path = Path("../../../../../../CFPQ_PyAlgo") //to do handle platform path
sys.path.insert(1, cfpq_pyalgo_path)

from src.problems.Base.algo.matrix_base.matrix_base import MatrixBaseAlgo
from src.graph.graph import Graph
from cfpq_data import cfg_from_txt

from src.problems.utils import ResultAlgo

import argparse

parser = argparse.ArgumentParser()
parser.add_argument("--dataset", help="the path to the input graph directory")
parser.add_argument("--grammar", help="the path to the grammar directory")
parser.add_argument("--output", help="the path to the output file")
args = parser.parse_args()

graph = Graph.from_txt(Path(args.dataset).joinpath("graph.txt")) //to do graph file name
grammar = cfg_from_txt(Path(args.grammar).joinpath("g.cfg")) //to do grammar file name
algo = MatrixBaseAlgo()
algo.prepare(graph, grammar)
res:ResultAlgo = algo.solve()
with open(Path(args.output)) as f:
    f.write(f'MatrixBaseAlgo: {res.matrix_S.nvals}') //to do format of the output
