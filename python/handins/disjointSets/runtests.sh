#!/bin/bash

inFiles=$(find . -maxdepth 1 -type f -name "*.in")
for file in $inFiles; do
    echo "Test case $file"
    cat "$file" | python3 disjointSets.py
    echo ""
    echo "w. path compression:"
    cat "$file" | python3 disjointSets_wPathCompression.py
done