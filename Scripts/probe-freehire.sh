#!/usr/bin/env bash

BASE="https://freehire.me/api/v1/jobs/search?limit=1&posted_within_days=7"

STACK="java%20OR%20spring%20OR%20react%20OR%20javascript"
CATS="backend,frontend,fullstack,software_engineering"

total() {
    local label="$1"
    local params="$2"

    local count

   count=$(curl -s "$BASE$params" | python3 -c "import sys,json; print(json.load(sys.stdin)['meta']['total'])")

   echo "$label: $count"
}

total "Base (7 días)" ""
total "Remotas" "&work_mode=remote"
total "Desarrollo remoto" "&work_mode=remote&category=backend,frontend,fullstack"
total "Colombia" "&countries=co"

total "Remotas definitivas" "&work_mode=remote&category=$CATS&q=$STACK"
total "Colombia definitiva" "&countries=co&work_mode=hybrid,onsite&category=$CATS&q=$STACK"


SEARCH="https://freehire.me/api/v1/jobs/search?posted_within_days=7"

page_size() {
    local limit="$1"
    local returned

    returned=$(curl -s "$SEARCH&limit=$limit" | python3 -c "import sys,json; print(len(json.load(sys.stdin)['data']))")

    echo "limit=$limit → devolvió: $returned"
}

page_size 100
page_size 200