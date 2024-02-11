#!/bin/bash

inFiles=$(find . -maxdepth 1 -type f -name "*.in")
for file in $inFiles; do
    echo "Test case $file"
    cat "$file" | java UnionFind.java
done