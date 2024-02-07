#!/bin/bash

inFiles=$(find . -maxdepth 1 -type f -name "*.in")
for file in $inFiles; do
    echo "Test case $file"
    cat "$file" | java disjointSets.java
    echo ""
    echo "w. path compression:"
    cat "$file" | java UnionFind_wPathCompression.java
done